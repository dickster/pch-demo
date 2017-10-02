/*
 * Copyright (c) brovada Technologies, Inc. All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * brovada Technologies, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with brovada.
 */

package com.brovada.policychange.service.comparitor;

import com.brovada.policychange.model.comparitor.PchJsonManifest;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class PchComparitorService {
    private static final Logger LOG = LoggerFactory.getLogger(PchComparitorService.class);

    private static final GroovyClassLoader GCL = new GroovyClassLoader();

    public PchJsonManifest compare(String oldXml, String newXml) {

        String scriptPath = "config/comparitor/pch.groovy";

        LOG.debug("Loading groovy class " + scriptPath);

        InputStream baseIS = this.getClass().getResourceAsStream("PolicyChangeBase.groovy");
        GroovyObject groovyObj = null;
        String baseString;
        try {
            baseString = IOUtils.toString(baseIS, "UTF-8");
            groovyObj = (GroovyObject) GCL.parseClass(baseString).newInstance();
        }
        catch (IOException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        LOG.debug("Policy Change New: " + newXml);
        LOG.debug("Policy Change Old: " + oldXml);

        assert groovyObj != null;
        return (PchJsonManifest) groovyObj.invokeMethod("init", new Object[]{scriptPath, oldXml, newXml});
    }
}