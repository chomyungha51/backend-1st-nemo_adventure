# backend-1st-nemo_adventure
조명하, 김민선

## logger를 사용해 게임 진행 상황을 game_log.log파일로 남기도록 수정
 
- 기존<br/>
src/nemos_Adventure/dev/service 하위에 있는 Game, State 클래스에서 sysout으로 출력

- 수정 후<br/>
Game, State에 logger를 만들어서 event가 일어날 때마다 game_log.log파일에 출력
