package network;
import handler.JsonHandler;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class HttpOperation {
    public static String get(String urlStr) {
        String body = null;
        InputStream in = null;
        HttpURLConnection httpConn = null;
        int resCode = -1;
        try {
            URL url = new URL(urlStr);
            URLConnection urlConn = url.openConnection();
            if (!(urlConn instanceof HttpURLConnection)) {
                throw new IOException("URL is not an Http URL");
            }
            httpConn = (HttpURLConnection) urlConn;
            httpConn.setRequestMethod("GET");
            httpConn.connect();
            resCode = httpConn.getResponseCode();
            if (resCode == HttpURLConnection.HTTP_OK) {
                in = httpConn.getInputStream();
                body = readBody(in);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpConn != null)
                httpConn.disconnect();
        }
        return body;
    }

    public static void post(String urlStr, String json) {
        InputStream in;
        HttpURLConnection httpConn = null;
        int resCode;
        try {
            URL url = new URL(urlStr);
            URLConnection urlConn = url.openConnection();
            if (!(urlConn instanceof HttpURLConnection)) {
                throw new IOException("URL is not an Http URL");
            }
            httpConn = (HttpURLConnection) urlConn;
            httpConn.setRequestMethod("POST");
            httpConn.setRequestProperty("Content-Type", "application/json");
            httpConn.setRequestProperty("Accept", "application/json");
            httpConn.setDoOutput(true);

            byte[] jsonBytes = json.getBytes("utf-8");
            OutputStream os = httpConn.getOutputStream();
            os.write(jsonBytes, 0, jsonBytes.length);

            httpConn.connect();
            resCode = httpConn.getResponseCode();
            if (resCode == HttpURLConnection.HTTP_OK) {
                in = httpConn.getInputStream();
                readBody(in);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpConn != null)
                httpConn.disconnect();
        }
    }
    public static String get(String urlStr) {
        String body = null;
        InputStream in = null;
        HttpURLConnection httpConn = null;
        int resCode = -1;
        try {
            URL url = new URL(urlStr);
            URLConnection urlConn = url.openConnection();
            if (!(urlConn instanceof HttpURLConnection)) {
                throw new IOException("URL is not an Http URL");
            }
            httpConn = (HttpURLConnection) urlConn;
            httpConn.setRequestMethod("GET");
            httpConn.connect();
            resCode = httpConn.getResponseCode();
            if (resCode == HttpURLConnection.HTTP_OK) {
                in = httpConn.getInputStream();
                body = readBody(in);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpConn != null)
                httpConn.disconnect();
        }
        return body;
    }
    public static void post(String urlStr, String json) {
        InputStream in;
        HttpURLConnection httpConn = null;
        int resCode;
        try {
            URL url = new URL(urlStr);
            URLConnection urlConn = url.openConnection();
            if (!(urlConn instanceof HttpURLConnection)) {
                throw new IOException("URL is not an Http URL");
            }
            httpConn = (HttpURLConnection) urlConn;
            httpConn.setRequestMethod("POST");
            httpConn.setRequestProperty("Content-Type", "application/json");
            httpConn.setRequestProperty("Accept", "application/json");
            httpConn.setDoOutput(true);

            byte[] jsonBytes = json.getBytes("utf-8");
            OutputStream os = httpConn.getOutputStream();
            os.write(jsonBytes, 0, jsonBytes.length);

            httpConn.connect();
            resCode = httpConn.getResponseCode();
            if (resCode == HttpURLConnection.HTTP_OK) {
                in = httpConn.getInputStream();
                readBody(in);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpConn != null)
                httpConn.disconnect();
        }
    }

}

