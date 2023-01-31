<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Join</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->



<!-- 폰트 및 아이콘 css -->
	<link rel="stylesheet" type="text/css" href="../fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!-- 폰트 및 아이콘 css end -->





<!-- 회원가입 css -->
	<link rel="stylesheet" type="text/css" href="../css/signin/util.css">
	<link rel="stylesheet" type="text/css" href="../css/join/join.css">
<!-- 회원가입 css End -->

</head>
<body>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic js-tilt" data-tilt>
					<img src="../images/img-01.png" alt="IMG">
				</div>

				<form class="login100-form" action="/auth/join" method="post">
					<span class="login100-form-title">
						Member Join
					</span>


					<div class="wrap-input100 validate-input" data-validate = "username is required">
                        <input class="input100" type="text" name="username" placeholder="username" required="required">
                        <span class="focus-input100"></span>
                        <span class="symbol-input100">
                            <i class="fa fa-id-card-o" aria-hidden="true"></i>
                        </span>
                    </div>


                    <div class="wrap-input100 validate-input" data-validate = "Password is required">
                        <input class="input100" type="password" name="password" placeholder="Password" required="required">
                        <span class="focus-input100"></span>
                        <span class="symbol-input100">
                            <i class="fa fa-lock" aria-hidden="true"></i>
                        </span>

                    </div>



					<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
						<input class="input100" type="text" name="email" placeholder="Email" required="required" >
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
					</div>



					<div class="wrap-input100 validate-input" data-validate = "name is required">
                    						<input class="input100" type="text" name="name" placeholder="Name" required="required">
                    						<span class="focus-input100"></span>
                    						<span class="symbol-input100">
                    							<i class="fa fa-user-circle-o" aria-hidden="true"></i>
                    						</span>

                    					</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Join
						</button>
					</div>

</br>
    </br>
        </br>
            </br>
                </br>
                    </br>
                        </br>
                            </br>




				</form>
			</div>
		</div>
	</div>




<!--===============================================================================================-->
	<script src="../vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="../vendor/bootstrap/js/popper.js"></script>
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