package ru.skypro.project.marketplace.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.project.marketplace.exception.ObjectNotFoundExeption;
import ru.skypro.project.marketplace.model.Image;
import ru.skypro.project.marketplace.repository.ImageRepository;

import java.io.IOException;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;



    public void remove(Image image) {
        imageRepository.delete(image);
        log.info("Image removed successfully");
    }


    public Image uploadImage(MultipartFile imageFile) throws IOException {
        log.debug("Uploading image file: " + imageFile.getOriginalFilename());
        Image image = new Image();
        image.setMediaType(imageFile.getContentType());
        image.setFileSize(imageFile.getSize());
        image.setData(imageFile.getBytes());
        Image savedImage = imageRepository.save(image);
        log.info("Image successfully uploaded with id {}", savedImage.getId());
        return savedImage;
    }


    public Image getImageById(Integer id) {
        log.debug("Getting image with id: {}", id);
        return imageRepository.findById(id).orElseThrow(ObjectNotFoundExeption::new);
    }
}
