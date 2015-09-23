package de.gesellix.docker.client

import spock.lang.Ignore
import spock.lang.Specification

@Ignore
class LowLevelDockerClientExplorationTest extends Specification {

    def "local test"() {
        def defaultDockerHost = System.env.DOCKER_HOST
//        defaultDockerHost = "http://192.168.99.100:2376"
//        defaultDockerHost = "unix:///var/run/docker.sock"
//        System.setProperty("docker.cert.path", "C:\\Users\\${System.getProperty('user.name')}\\.boot2docker\\certs\\boot2docker-vm")
//        System.setProperty("docker.cert.path", "/Users/${System.getProperty('user.name')}/.docker/machine/machines/default")
        def client = new LowLevelDockerClient(dockerHost: defaultDockerHost ?: "http://172.17.42.1:4243/")

        def response
//        response = client.get("/_ping")
//        println response
//        response = client.get("/version")
//        println response
//        response = client.get("/info")
//        println response
//        response = client.get([path: "/images/json", query: [filters: new JsonBuilder([dangling: ["true"]]).toString()]])
//        println response
//        response = client.get([path: "/containers/json", query: [filters: new JsonBuilder([status: ["exited"]]).toString()]])
//        println response
//        response = client.get("/containers/test/json")
//        println response
//        response = client.post("/containers/test/attach?logs=1&stream=1&stdout=1&stderr=0&tty=false")
//        println response
//        response = client.post("/images/create?fromImage=gesellix%2Fdocker-client-testimage&tag=latest&registry=")
//        println response
//        response = client.post([path : "/images/create",
//                                query: [fromImage: "gesellix/docker-client-testimage", tag: "latest", "registry": ""]])
//        println response

        expect:
        1 == 1
    }
}
