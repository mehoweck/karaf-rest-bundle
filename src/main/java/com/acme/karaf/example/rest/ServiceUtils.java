package com.acme.karaf.example.rest;

import java.util.List;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

public class ServiceUtils {

    /**
     * Identify the preferred {@link MediaType} from the list provided. This
     * will check for JSON string or {@link MediaType} first then XML.
     *
     * @param types
     *            List of {@link MediaType} values;
     * @return selected {@link MediaType}
     */
    public static MediaType mediaType(List<MediaType> types) {
        MediaType aMediaType;
        if (types != null) {
            for (MediaType type : types) {
                aMediaType = type;
                if (aMediaType.isCompatible(MediaType.APPLICATION_JSON_TYPE)) {
                    return MediaType.APPLICATION_JSON_TYPE;
                }
                if (aMediaType.isCompatible(MediaType.APPLICATION_XML_TYPE)) {
                    return MediaType.APPLICATION_XML_TYPE;
                }
                if (aMediaType.isCompatible(MediaType.APPLICATION_OCTET_STREAM_TYPE)) {
                    return MediaType.APPLICATION_OCTET_STREAM_TYPE;
                }
//                if (aMediaType.isCompatible(AbstractResource.APPLICATION_SCHEMA_JSON_TYPE)) {
//                    return AbstractResource.APPLICATION_SCHEMA_JSON_TYPE;
//                }
            }
        }
        // An unsupported media type never comes to resource, no need to throw exception here.
        return MediaType.APPLICATION_JSON_TYPE;
    }

    public static MediaType getResponseMediaType(HttpHeaders headers) {
        MediaType mediaType = MediaType.TEXT_PLAIN_TYPE;
        if (headers != null) {
            List<MediaType> accepts = headers.getAcceptableMediaTypes();
            if (accepts != null && accepts.size() > 0) {
//                try {
                    mediaType = mediaType(accepts);
//                } catch (Exception ex) {
//                    JPARSLogger.exception("Exception in getResponseMediaType", new Object[]{headers}, ex);
//                }
            }
        }
        return mediaType;
    }
}
