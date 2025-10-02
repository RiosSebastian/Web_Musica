package com.example.WebDeMusica.util;

import jakarta.persistence.Lob;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResposeFile {
    private String name;
    private String url;
    private String type;
    private String size;
}
