package com.kafkaintegration.kafkaintegration.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.Optional;

public class ResponseSupport {

    public <T> ResponseEntity<T> build(HttpStatus httpStatus, T body, Map<String, String> headers) {
        ResponseEntity.BodyBuilder builder = ResponseEntity.status(httpStatus);
        if (headers != null) {
            headers.forEach((k, v) -> builder.headers(header -> header.add(k, v)));
        }
        return builder.body(body);
    }

    public <T> ResponseEntity<T> accepted() {
        return build(HttpStatus.ACCEPTED, null, null);
    }

    public <T> ResponseEntity<T> partial() {
        return build(HttpStatus.PARTIAL_CONTENT, null, null);
    }

    public <T> ResponseEntity<T> partial(T entity) {
        return build(HttpStatus.PARTIAL_CONTENT, entity, null);
    }

    public <T> ResponseEntity<T> conflict() {
        return build(HttpStatus.CONFLICT, null, null);
    }

    public <T> ResponseEntity<T> ok(Optional<T> body) {
        if (body.isPresent()) {
            return ok(body.get());
        }
        return noContent();
    }


    public <T> ResponseEntity<T> ok(T body) {
        return build(HttpStatus.OK, body, null);
    }

    public <T> ResponseEntity<T> ok() {
        return build(HttpStatus.OK, null, null);
    }

    public <T> ResponseEntity<T> empty() {
        return build(HttpStatus.NO_CONTENT, null, null);
    }

    public <T> ResponseEntity<T> created() {
        return build(HttpStatus.CREATED, null, null);
    }

    public <T> ResponseEntity<T> created(T body) {
        return build(HttpStatus.CREATED, body, null);
    }

    public <T> ResponseEntity<T> noContent() {
        return build(HttpStatus.NO_CONTENT, null, null);
    }

    public <T> ResponseEntity<T> badRequest() {
        return build(HttpStatus.BAD_REQUEST, null, null);
    }

    public <T> ResponseEntity<T> badRequest(T body) {
        return build(HttpStatus.BAD_REQUEST, body, null);
    }
}

