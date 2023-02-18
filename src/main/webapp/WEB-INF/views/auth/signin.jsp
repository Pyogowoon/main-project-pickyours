<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">


<!-- 글씨체 및 아이콘 -->
	<link rel="stylesheet" type="text/css" href="../fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!-- 글씨체 및 아이콘 End -->

 <!-- 로그인 css -->

	<link rel="stylesheet" type="text/css" href="../css/signin/util.css">
	<link rel="stylesheet" type="text/css" href="../css/signin/signin.css">
<!-- 로그인 css End -->

</head>
<body>



	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
			<div class="back" onclick="javascript:location.href='/' " style="cursor:pointer" ><img src="/images/left.png" style="width:50px;height:50px;"></div>
				<div class="login100-pic js-tilt" data-tilt>
					<img src="../images/img-01.png" alt="IMG">
				</div>

				<form class="login100-form validate-form" action="/auth/signin" method="post">

					<span class="login100-form-title">
						Member Login
					</span>

					<div class="wrap-input100 validate-input" data-validate = "아이디를 적어주세요!">
						<input class="input100" type="text" name="username" placeholder="username">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-id-card-o" aria-hidden="true"></i>
						</span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "비밀번호를 적어주세요!">
						<input class="input100" type="password" name="password" placeholder="Password">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
					</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn" type="submit">
							Login
						</button>
					</div>

					<div class="text-center p-t-12">
						<span class="txt1">
                            <c:if test="${error}">
                                <p id="valid" class="alert alert-danger">${exception}</p>
                            </c:if>
                        </span>
						</span>

						<br/>
						<br/>


                            <!-- Oauth 소셜로그인 -->

                            <!-- kakao Login -->

                            <div class="login__kakao">
                           <button onclick="javascript:location.href='/oauth2/authorization/kakao'">
                             <img src="../images/kakaologin.png" style="height:53px;width:280px">
                            </button>
                        </div>

                           <!-- kakao Login End-->

                           <!-- naver Login -->
                             <div class="login__naver">
                              <button onclick="javascript:location.href='/oauth2/authorization/naver'">
                                <img src="../images/naverlogin.png" style="height:53px;width:280px">
                               </button>
                           </div>

                           <!-- naver Login End -->

                               <!-- facebook -->
                           <div class="login__facebook">
                              <button onclick="javascript:location.href='/oauth2/authorization/facebook'">
                                <img src="../images/facebooklogin.png" style="height:53px;width:280px">
                               </button>
                           </div>

                             <!-- facebook End-->

                        <!-- Oauth 소셜로그인 End -->


					</div>

					    <div class="text-center p-t-136">
						<a class="txt2" href="../auth/join">
							Create your Account
							<i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
						</a>
					    </div>

				</form>

			</div>
		</div>
	</div>




<!--===============================================================================================-->
	<script src="../vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="../vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="../vendor/tilt/tilt.jquery.min.js"></script>
	<script >
		$('.js-tilt').tilt({
			scale: 1.1
		})
	</script>
<!--===============================================================================================-->
	<script src="../js/signin/signin.js"></script>

</body>
</html>