package ir.maktab.service.reader;

import java.io.*;

public class ImageReader {
    public byte[] fileToBytes(String filename) throws IOException {
        final byte[] buffer = new byte[256];
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            try (InputStream in = new FileInputStream(new File(filename))) {
                int bytesRead;
                while ((bytesRead = in.read(buffer)) > 0)
                    out.write(buffer, 0, bytesRead);
            }
            return out.toByteArray();
        }
    }
}