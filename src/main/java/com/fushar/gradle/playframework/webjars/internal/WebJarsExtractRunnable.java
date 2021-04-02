package com.fushar.gradle.playframework.webjars.internal;

import org.gradle.util.GFileUtils;

import javax.inject.Inject;
import com.fushar.gradle.playframework.webjars.WebJarsExtractSpec;

public class WebJarsExtractRunnable implements Runnable {
    private final WebJarsExtractSpec spec;

    @Inject
    public WebJarsExtractRunnable(WebJarsExtractSpec spec) {
        this.spec = spec;
    }

    @Override
    public void run() {
        GFileUtils.forceDelete(spec.getDestinationDir());
        new WebJarsExtractor().execute(spec);
    }
}
