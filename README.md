# jwt

jwt 진행 순서
1. 클라이언트 사용자가 아이디, 패스워드를 통해 웹서비스 인증.
2. 서버에서 서명된(Signed) JWT를 생성하여 클라이언트에 응답으로 돌려주기
3. 클라이언트가 서버에 데이터를 추가적으로 요구할 때 JWT를 HTTP Header에 첨부
4. 서버에서 클라이언트로부터 온 JWT를 검증

1.사용자가 http request.

2-1.로그인 요청이라면 (UsernamePasswordAuthenticationFilter를 상속한) AuthenticationFilter가
attemptAuthentication()를 실행되고 그 후 successfulAuthentication()을 실행된다.
해당 과정에서 토큰을 만들고 해당 토큰을 response 헤더에 담아준다.

2-2.이미 토큰을 발급받아 같이 요청한 상태라면, (UsernamePasswordAuthenticationFilter를상속한) AuthenticationFilter에서 아무런 동작없이 바로 인가처리로 이어진다.
(BasicAuthenticationFilter를 상속한 AuthorizationFilter)

3.BasicAuthenticationFilter를 상속한 AuthorizationFilter에서 받은 토큰을 parse하여 해당 Id가 db에
저장되어 있는지 확인한다.그후 존재한다면,해당 유저정보와 해당 유저의 권한이 담긴 토큰을
SecurityContextHolder를 사용하여 세션값에 저장한다.(권한 부여)
Ex) SecurityContextHolder.getContext().setAuthentication(authentication);