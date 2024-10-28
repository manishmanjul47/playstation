package com.play.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;


@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MediaTextModel {

    @ValueMapValue
    private String heading;

    @ValueMapValue
    private String image;

    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
    private List<Step> steps;

    public String getHeading() {
        return heading;
    }

    public String getImage() {
        return image;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public static class Step {
        @ValueMapValue
        private String numbertext;

        public String getNumbertext() {
            return numbertext;
        }

        @ValueMapValue
        private String text;



        public String getText() {
            return text;
        }
    }

}
