package com.brovada.document.config;

import java.util.Optional;

public interface ComponentConfig {

    ComponentType getType();

    default Optional<String> getCss() {
        return Optional.empty();
    };


//    default Optional<String> getFeedback() {
//        return Optional.empty();
//    }


}

