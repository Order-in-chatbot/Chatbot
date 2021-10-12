<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>storefind</title>
</head>
<body>
<form class="StoreForm" action="${path}/chatbot/store/storefind" method=post>
 <input type="text" name="NO" size=20>
 <label for="id">NO</label>
 <div class="btn-area">
      <input type="submit" value="find">
 </div>
</form>

</body>
</html>