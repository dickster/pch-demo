package com.brovada.old.document.config;

import java.util.List;

public interface HasChildren {

    List<? extends ComponentConfig> getChildren();

}
