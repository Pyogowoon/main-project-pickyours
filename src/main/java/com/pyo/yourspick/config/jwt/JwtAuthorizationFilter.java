package com.pyo.yourspick.config.jwt;


/* 임시적으로 주석 처리
public class JwtAuthorizationFilter {


    private UserRepository userRepository;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UserRepository userRepository) {
        super(authenticationManager);
        this.userRepository = userRepository;

    }

    // 인증이나 권한이 필요한 주소요쳥이 있을 때 해당 필터를 타게 됨.
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//        super.doFilterInternal(request, response, chain);
        System.out.println("인증이나 권한이 필요한 주소요청이 됨");


        String jwtHeader = request.getHeader("Authorization");
        System.out.println("jwtHeader :" + jwtHeader);

        //jwt header에 bareaer ~ 값이 날라오면 토큰을 검증해서 정상적인 사용자인지 확인
        // header가 있는지 확인 , 또 정상적인지 확인
        if (jwtHeader == null || !jwtHeader.startsWith("Bearer")) {
            chain.doFilter(request, response);
            return;
        }
        String jwtToken = request.getHeader("Authorization").replace("Bearer ", ""); // Bearer 가 없어지고 공백되서 순수 토큰값만 들어감

        String username = JWT.require(Algorithm.HMAC512("cos")).build().verify(jwtToken)
                .getClaim("username").asString();
        // jwtAuthenticationFilter 와 같은값으로

        /* 서명이 제대로 되었을 경우 */
/*
        if (username != null) {
            System.out.println("username 정상 ");
            User userEntity = userRepository.findByUsername(username);
            System.out.println("정상 밑 userEntity : " + userEntity.getUsername());
            PrincipalDetails principalDetails = new PrincipalDetails(userEntity);

            //Jwt 토큰 서명을 통해서 서명이 정상이면 Authentication 객체를 만들어준다.
            Authentication authentication =
                    // 강제로 어센티케이션 객체를 만듬 이유는 if문에서 username이 인증됐다는 건 정상적인 유저라는 뜻이라서
                    new UsernamePasswordAuthenticationToken(principalDetails, null, principalDetails.getAuthorities());

            // 강제로 시큐리티의 세션에 접근하여 Authentiacation 객체를 저장
            SecurityContextHolder.getContext().setAuthentication(authentication);

        }
        chain.doFilter(request, response);
    }
}
/*

/*

 */
