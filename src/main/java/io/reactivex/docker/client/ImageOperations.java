package io.reactivex.docker.client;

import io.reactivex.docker.client.http_client.HttpStatus;
import io.reactivex.docker.client.representations.DockerImage;
import io.reactivex.docker.client.representations.DockerImageInfo;
import okio.Buffer;
import rx.Observable;

import java.nio.file.Path;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public interface ImageOperations {

    String IMAGE_ENDPOINT = "images";
    String IMAGE_CREATE_ENDPOINT = IMAGE_ENDPOINT + "/create?fromImage=%s%s&tag=%s";
    String IMAGE_LIST_ENDPOINT = IMAGE_ENDPOINT + "/json";
    String IMAGE_REMOVE_ENDPOINT = IMAGE_ENDPOINT + "/%s";
    String IMAGE_SEARCH_ENDPOINT = IMAGE_ENDPOINT + "/search";
    String IMAGE_BUILD_ENDPOINT = "build";

    Observable<Buffer> pullImageObs(String image, final Optional<String> user, final Optional<String> tag);

    HttpStatus pullImage(String fromImage, String user, String tag);

    HttpStatus pullImage(String fromImage, String tag);

    HttpStatus pullImage(String fromImage);

    Stream<DockerImage> listImages(ImageListQueryParameters queryParameters);

    Observable<DockerImage> listImagesObs(ImageListQueryParameters queryParameters);

    Stream<DockerImage> listAllImages();

    Stream<DockerImage> listImages(String imageName);

    Stream<DockerImage> listImages();

    Stream<DockerImage> listDanglingImages();

    Observable<HttpStatus> removeImageObs(String imageName);

    Observable<HttpStatus> removeImageObs(String imageName, boolean noPrune, boolean force);

    HttpStatus removeImage(String imageName, boolean noPrune, boolean force);

    HttpStatus removeImage(String imageName);

    default void removeAllImages() {
        removeImages(d -> true);
    }

    default void removeImages(Predicate<DockerImage> predicate) {
        listAllImages().filter(predicate).forEach(image -> {
            System.out.println(String.format("Deleting image with id %s", image.id()));
            removeImage(image.id(), false, true);
        });
    }

    default void removeDanglingImages() {
        listDanglingImages().forEach(image -> {
            System.out.println(String.format("Deleting dangling image with id %s", image.id()));
            removeImage(image.id(), false, true);
        });
    }

    default Stream<DockerImageInfo> searchImages(String searchTerm) {
        return searchImages(searchTerm, t -> true);
    }

    Stream<DockerImageInfo> searchImages(String searchTerm, Predicate<DockerImageInfo> predicate);

    default Observable<DockerImageInfo> searchImagesObs(String searchTerm) {
        return searchImagesObs(searchTerm, t -> true);
    }

    Observable<DockerImageInfo> searchImagesObs(String searchTerm, Predicate<DockerImageInfo> predicate);

    public Observable<String> buildImageObs(final String repositoryName, final Path pathToTarArchive);

}
