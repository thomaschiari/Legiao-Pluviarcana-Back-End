package com.example.app.denuncia.DTO;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.core.sync.RequestBody;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import lombok.*;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class DenunciaPostDTO {
    private String nome;

    private String dataEnchente;

    private String local;

    private String relato;

    private String idade;

    private String media;

    private String link;

    private String mediaType;

    private static final String AWS_REGION = "us-east-2";
    private static final String BUCKET_NAME = "projquebrada";

    public static void uploadBase64MediaToS3(String base64Media, String FILE_NAME) throws IOException {
        byte[] mediaData = Base64.getDecoder().decode(base64Media);

        // Cria um arquivo temporário
        File tempFile = File.createTempFile("media", null);
        try (FileOutputStream fos = new FileOutputStream(tempFile)) {
            fos.write(mediaData);
        }

        // Configura o cliente S3
        S3Client s3Client = S3Client.builder()
                .region(Region.of(AWS_REGION))
                .build();

        // Envia o arquivo para o bucket S3
        s3Client.putObject(PutObjectRequest.builder()
                .bucket(BUCKET_NAME)
                // Gerar uma key por hash para ser o nome do arquivo
                .key(FILE_NAME)
                .build(), RequestBody.fromFile(tempFile));

        // Deleta o arquivo temporário
        tempFile.delete();
    }

    public static DenunciaSaveDTO covDenunciaSaveDTO(DenunciaPostDTO d){
    

        if (d.getLink() != null){
            return new DenunciaSaveDTO(d.getNome(),d.getDataEnchente(),d.getLocal(),d.getRelato(),d.getIdade(),d.getLink(),d.getMediaType());
        }

        String FILE_NAME = "folder/media-" + System.currentTimeMillis() + d.getMediaType();

        try {
            uploadBase64MediaToS3(d.getMedia(), FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String link_ = "https://projquebrada.s3.amazonaws.com/" + FILE_NAME;

        return new DenunciaSaveDTO(d.getNome(),d.getDataEnchente(),d.getLocal(),d.getRelato(),d.getIdade(),link_,d.getMediaType());
    }
}
