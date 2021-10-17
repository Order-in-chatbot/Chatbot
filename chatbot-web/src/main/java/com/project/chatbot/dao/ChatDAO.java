package com.project.chatbot.dao;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.google.gson.Gson;

public class ChatDAO {
	//private static final String OPEN_API_URL="http://aiopen.etri.re.kr:8000/Dialog";
		//private static final String ACCESS_KEY="0d8e5b69-dabd-4652-912e-640b6ad77bcf";
		//����� API Key
				private static final String ACCESS_KEY="0d8e5b69-dabd-4652-912e-640b6ad77bcf";
				private static final String KAKAO_ACCESS_KEY = "b1188f7547025e5c1c4c9512dbe814f5";

				public String open() {
					String openApiURL = "http://aiopen.etri.re.kr:8000/Dialog";
					String accessKey = ACCESS_KEY; // �߱޹��� API Key
					String domain = "Mc_donald"; // ������ ��
					String access_method = "internal_data"; // ������ ���
					String method = "open_dialog"; // method ȣ�� ���
					Gson gson = new Gson();

					Map<String, Object> request = new HashMap<>();
					Map<String, String> argument = new HashMap<>();

					////////////////////////// OPEN DIALOG //////////////////////////

					argument.put("name", domain);
					argument.put("access_method", access_method);
					argument.put("method", method);

					request.put("access_key", accessKey);
					request.put("argument", argument);

					URL url;
					Integer responseCode = null;
					String responBody = null;
					try {
						url = new URL(openApiURL);
						HttpURLConnection con = (HttpURLConnection) url.openConnection();
						con.setRequestMethod("POST");
						con.setDoOutput(true);

						DataOutputStream wr = new DataOutputStream(con.getOutputStream());
						wr.write(gson.toJson(request).getBytes("UTF-8"));
						wr.flush();
						wr.close();

						responseCode = con.getResponseCode();
						InputStream is = con.getInputStream();
						byte[] buffer = new byte[is.available()];
						int byteRead = is.read(buffer);
						responBody = new String(buffer);

						System.out.println("[responseCode] " + responseCode);
						System.out.println("[responBody]");
						System.out.println(responBody);

					} catch (MalformedURLException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}

					return responBody;
				}

				public static String message(Map map) {

					String openApiURL = "http://aiopen.etri.re.kr:8000/Dialog";
					String accessKey = ACCESS_KEY; // �߱޹��� API Key
					String uuid = (String) map.get("uuid"); // Open Dialog�� ���� ������ UUID
					String method = "dialog"; // method ȣ�� ���
					String text = (String) map.get("text"); // method ȣ�� ���
					Gson gson = new Gson();

					Map<String, Object> request = new HashMap<>();
					Map<String, String> argument = new HashMap<>();

					////////////////////////// OPEN DIALOG //////////////////////////

					argument.put("uuid", uuid);
					argument.put("method", method);
					argument.put("text", text);

					request.put("access_key", accessKey);
					request.put("argument", argument);

					URL url;
					Integer responseCode = null;
					String responBody = null;
					try {
						url = new URL(openApiURL);
						HttpURLConnection con = (HttpURLConnection) url.openConnection();
						con.setRequestMethod("POST");
						con.setDoOutput(true);

						DataOutputStream wr = new DataOutputStream(con.getOutputStream());
						wr.write(gson.toJson(request).getBytes("UTF-8"));
						wr.flush();
						wr.close();

						responseCode = con.getResponseCode();
						InputStream is = con.getInputStream();
						byte[] buffer = new byte[is.available()];
						int byteRead = is.read(buffer);
						responBody = new String(buffer);

						System.out.println("[responseCode] " + responseCode);
						System.out.println("[responBody]");
						System.out.println(responBody);

					} catch (MalformedURLException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}

					return responBody;
				}

				public String tts(String folderpath, String text) {

					String openApiURL = "https://kakaoi-newtone-openapi.kakao.com/v1/synthesize";
					String REST_API_KEY = "b1188f7547025e5c1c4c9512dbe814f5";
					String data = "<speak>" + text + "</speak>";
//				            + "<voice name=\"MAN_DIALOG_BRIGHT\">"+text+"</voice> \r\n"
//				            + "</speak>";

					URL url;
					Integer responseCode = null;
					String responBody = null;
					String filename = "";
					UUID uuid = UUID.randomUUID();

					try {
						url = new URL(openApiURL);
						HttpURLConnection con = (HttpURLConnection) url.openConnection();
						con.setRequestProperty("Content-Type", "application/xml");
						con.setRequestProperty("Authorization", String.format("KakaoAK %s", REST_API_KEY));
						con.setRequestMethod("POST");
						con.setDoOutput(true);

						DataOutputStream wr = new DataOutputStream(con.getOutputStream());
						wr.write(data.getBytes("UTF-8"));
						wr.flush();
						wr.close();

						responseCode = con.getResponseCode();

						File folder = new File(folderpath);
						if (folder.exists() == false)
							folder.mkdirs();

						filename = uuid.toString() + ".mp3";
						File file = new File(folderpath + File.separator + filename);
						copyInputStreamToFile(con.getInputStream(), file);

						InputStream is = con.getInputStream();

					} catch (MalformedURLException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}

					return filename;
				}

				private static void copyInputStreamToFile(InputStream inputStream, File file) throws IOException {
					// append = false
					try (FileOutputStream outputStream = new FileOutputStream(file, false)) {
						int read;
						byte[] bytes = new byte[8192];
						while ((read = inputStream.read(bytes)) != -1) {
							outputStream.write(bytes, 0, read);
						}
					}
				}
			}
