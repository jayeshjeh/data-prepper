/*
 * Copyright OpenSearch Contributors
 * SPDX-License-Identifier: Apache-2.0
 */

package org.opensearch.dataprepper.plugins.processor.otelmetrics;

import static org.opensearch.dataprepper.plugins.otel.codec.OTelProtoCodec.DEFAULT_EXPONENTIAL_HISTOGRAM_MAX_ALLOWED_SCALE;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder
@JsonClassDescription("The `otel_metrics` processor serializes a collection of `ExportMetricsServiceRequest` records " +
        "sent from the [OTel metrics source](https://opensearch.org/docs/latest/data-prepper/pipelines/configuration/sources/otel-metrics-source/) into a collection of string records.")
public class OtelMetricsRawProcessorConfig {

    @JsonProperty("flatten_attributes")
    @JsonPropertyDescription("Whether or not to flatten the `attributes` field in the JSON data.")
    boolean flattenAttributesFlag = true;

    @JsonPropertyDescription("Whether or not to calculate histogram buckets.")
    private Boolean calculateHistogramBuckets = true;

    @JsonPropertyDescription("Whether or not to calculate exponential histogram buckets.")
    private Boolean calculateExponentialHistogramBuckets = true;

    @JsonPropertyDescription("Maximum allowed scale in exponential histogram calculation.")
    private Integer exponentialHistogramMaxAllowedScale = DEFAULT_EXPONENTIAL_HISTOGRAM_MAX_ALLOWED_SCALE;

    public Boolean getCalculateExponentialHistogramBuckets() {
        return calculateExponentialHistogramBuckets;
    }

    public Boolean getCalculateHistogramBuckets() {
        return calculateHistogramBuckets;
    }

    public Integer getExponentialHistogramMaxAllowedScale() {
        return exponentialHistogramMaxAllowedScale;
    }

    public Boolean getFlattenAttributesFlag() {
        return flattenAttributesFlag;
    }
}
