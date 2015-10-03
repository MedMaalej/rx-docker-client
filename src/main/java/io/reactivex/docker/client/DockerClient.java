package io.reactivex.docker.client;

import io.netty.buffer.ByteBuf;
import io.reactivex.netty.protocol.http.client.HttpClientResponse;
import rx.Observable;

public interface DockerClient extends MiscOperations, ContainerOperations, ImageOperations {

    String DEFAULT_DOCKER_HOST = "localhost";
    int DEFAULT_DOCKER_PORT = 2375;

    /**
     * Builds the client using DOCKER_HOST and DOCKER_CERT_PATH environment variables
     *
     * @return a new instance of RxDockerClient
     */
    public static DockerClient fromDefaultEnv() {
        return newDockerClient(System.getenv("DOCKER_HOST"), System.getenv("DOCKER_CERT_PATH"));
    }

    public static RxDockerClient newDockerClient(final String dockerHost, final String dockerCertPath) {
        return new RxDockerClient(dockerHost, dockerCertPath);
    }

    String getApiUri();

    Observable<HttpClientResponse<ByteBuf>> pullImageObs(String fromImage);
}
