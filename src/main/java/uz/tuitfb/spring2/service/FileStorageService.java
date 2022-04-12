package uz.tuitfb.spring2.service;

import org.hashids.Hashids;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import uz.tuitfb.spring2.domain.FileStorage;
import uz.tuitfb.spring2.domain.FileStorageStatus;
import uz.tuitfb.spring2.repository.FileStorageRepository;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class FileStorageService {


    private final FileStorageRepository fileStorageRepository;
    private final Hashids hashids;
    @Value("${upload.folder}")
    private String uploadFolder;

    public FileStorageService(FileStorageRepository fileStorageRepository) {
        this.fileStorageRepository = fileStorageRepository;
        this.hashids = new Hashids(getClass().getName(), 6);

    }

    public void save(MultipartFile multipartFile) {
        FileStorage fileStorage = new FileStorage();
        fileStorage.setName(multipartFile.getOriginalFilename());
        fileStorage.setExtention(getext(multipartFile.getOriginalFilename()));
        fileStorage.setFileSize(multipartFile.getSize());
        fileStorage.setContentType(multipartFile.getContentType());
        fileStorage.setFileStorageStatus(FileStorageStatus.DRAFT);
        fileStorageRepository.save(fileStorage);


        Date now = new Date();
        File uploadFolder = new File(String.format("%s/upload_files/%d/%d/%d/", this.uploadFolder,
                1900 + now.getYear(), 1 + now.getMonth(), now.getDate()));
        if (!uploadFolder.exists() && uploadFolder.mkdirs()) {
            System.out.println("Aytilgan papka yaratildi");
        }
        fileStorage.setHashId(hashids.encode(fileStorage.getId()));
        fileStorage.setUploadPath(String.format("upload_files/%d/%d/%d/%s.%s",
                1900 + now.getYear(),
                1 + now.getMonth(),
                now.getDate(),
                fileStorage.getHashId(),
                fileStorage.getExtention()
        ));
        fileStorageRepository.save(fileStorage);
        uploadFolder = uploadFolder.getAbsoluteFile();
        File file = new File(uploadFolder, String.format("%s.%s", fileStorage.getHashId(), fileStorage.getExtention()));

        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Transactional(readOnly = true)
    public FileStorage findByhashId(String hashid) {
        return fileStorageRepository.findAllByHashId(hashid);
    }


    public void delete(String hashId) {
        FileStorage fileStorage = findByhashId(hashId);
        File file = new File(String.format("%s/%s", this.uploadFolder, fileStorage.getUploadPath()));
        if (file.delete()) {
            fileStorageRepository.delete(fileStorage);
        }
    }

    @Scheduled(cron = "1 0 0 * * *")
    public void deleteAllDraft() {
        List<FileStorage> fileStorageList = fileStorageRepository.findAllByFileStorageStatus(FileStorageStatus.DRAFT);


        fileStorageList.forEach(fileStorage -> {
            delete(fileStorage.getHashId());
        });

    }


    private String getext(String fileName) {
        String ext = null;
        if (fileName != null && !fileName.isEmpty()) {
            int dot = fileName.lastIndexOf('.');
            if (dot > 0 && dot <= fileName.length() - 2) ;
            {
                ext = fileName.substring(dot + 1);

            }
        }
        return ext;
    }
}
