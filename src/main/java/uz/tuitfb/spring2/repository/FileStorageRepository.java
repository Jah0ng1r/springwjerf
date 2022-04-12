package uz.tuitfb.spring2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.tuitfb.spring2.domain.FileStorage;
import uz.tuitfb.spring2.domain.FileStorageStatus;

import java.util.List;

@Repository

public interface FileStorageRepository extends JpaRepository<FileStorage, Long> {


    FileStorage findAllByHashId(String hashid);

    List<FileStorage> findAllByFileStorageStatus(FileStorageStatus status);

}
