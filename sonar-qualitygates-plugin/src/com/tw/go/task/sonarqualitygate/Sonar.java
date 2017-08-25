package com.tw.go.task.sonarqualitygate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;


@Data
public class Sonar {
    SonarStatus projectStatus;

    @Data
    class SonarStatus {
        ProjectStatus status;
        List<SonarCondition> conditions;
        List<SonarPeriod> periods;
    }

    @AllArgsConstructor
    enum ProjectStatus {
        OK("ok"), WARN("warn"), ERROR("error"), NONE("none");

        @Getter
        final String value;
    }

    @Data
    class SonarCondition {
        String status;
        String metricKey;
        String comparator;

        Integer periodIndex;
        String errorThreshold;
        String actualValue;
    }

    @Data
    class SonarPeriod {
        Integer index;
        String mode;
        String date;
    }
}
