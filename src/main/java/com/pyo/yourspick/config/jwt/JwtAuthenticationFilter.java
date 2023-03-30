package com.pyo.yourspick.config.jwt;

/* 일시적으로 주석처리 ( 미완성 )
public class JwtAuthenticationFilter {


    private final AuthenticationManager authenticationManager;

    //login 요청을 하면 로그인 시도를 위해서 실행되는 함수
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        System.out.println("JwtAuthenticationFilter : 로그인 시도중");

        // 1.username , password 받아서
        try {
//            BufferedReader br = request.getReader();
//
//            String input = null;
//            while((input = br.readLine()) !=null){
//                System.out.println(input);
//            }

            // JSON 데이터를 파싱해줌
            ObjectMapper om = new ObjectMapper();
            User user = om.readValue(request.getInputStream(), User.class);
            System.out.println(user);

            // 토큰도 하나 개별적으로 만들어줘야함. 폼 로그인 했을때는 자동으로 해주던것
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

            // PrincipalDetailsService 의 loadUserByUsername() 함수가 실행됨
            Authentication authentication =
                    authenticationManager.authenticate(authenticationToken);

            // 로그인이 되었다는 뜻.
            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();

            System.out.println("로그인완료됨 :  " + principalDetails.getUsername());

            //얘로 리턴해주면 된다. authentication 객체가 session 영역에 저장됨 => 그럼 얘가 세션에 저장이됨
            //리턴하는 이유는 권한 관리를 security가 대신 해주기때문에 편하라고


            return authentication;
//            System.out.println(request.getInputStream().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    //attemptAuthentication 실행 후 인증이 정상적으로 되었으면 successfulAuthentication 함수가 실행 됨
    // JWT 토큰을 만들어서 request요청한 사용자에게 JWT 토큰을 response 해주면 됨.
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        System.out.println("successfulAuthentication 실행됨  : 인증 완료 ");
        PrincipalDetails principalDetails = (PrincipalDetails) authResult.getPrincipal();

        //RSA 방식은 아니고 Hash암호방식
        String jwtToken = JWT.create()
                .withSubject("jwt토큰")
                .withExpiresAt(new Date(System.currentTimeMillis() + (60000 * 10)))  // 60000 = 1분
                .withClaim("id", principalDetails.getUser().getId()) //넣어주고싶은 값, 나는 아이디와 유저네임을 넣음, 비공개 클레임임
                .withClaim("username", principalDetails.getUser().getUsername())
                .sign(Algorithm.HMAC512("cos")); // 내 서버만 아는 고유한 값 (이거로 사인하는거)

        //Bearer 다음 한칸 꼭 띄워줘야함
        response.addHeader("Authorization", "Bearer " + jwtToken);


//        super.successfulAuthentication(request, response, chain, authResult);
    }
}
*/