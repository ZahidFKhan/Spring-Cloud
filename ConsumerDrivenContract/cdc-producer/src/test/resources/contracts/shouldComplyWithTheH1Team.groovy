package contracts

import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.cloud.contract.spec.Contract

Contract.make {
//    description "should return all customers"
    request {
        url("/")
        method GET()
    }
    response {
        status 200
        headers {
            header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        }
        body(
                [
                        [
                                id  : 1,
                                name: "Zahid"
                        ],
                        [
                                id  : 2,
                                name: "Arif"
                        ]
                ]
        )
    }
}