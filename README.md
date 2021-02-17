# java-lotto
로또 미션 진행을 위한 저장소

## 요구사항

* [x]구입금액을 입력한다.  
* [x]구입 가능한 로또 매수를 구한다.  
* [x]로또를 매수만큼 생성한다.  
* [x]로또 1개를 생성한다.
* [x]생성된 로또들을 출력한다.  
* [x]당첨 번호를 입력 받는다.  
* [x]보너스 볼을 입력한다.  
* [x]개개별 로또 결과를 수합한다.  
* [x]당첨 통계를 계산한다.  
* [x]당첨 통계를 출력한다.

## Lotto
- 6개의 수를 가지고 있는 list를 필드로 갖고있음.
- 생성시에 랜덤 숫자 프로퍼티를 가지게 함.
- 당첨번호와 몇 개가 일치한지 개수를 계산한다.

## Lottos
- List<Lotto> 를 가지고 있음.
- 당첨 통계 계산의 역할을 가지고 있음.

## LottoGenerator
- 6개의 랜덤 번호를 가진 로또를 생성한다.

## LottoStore
- 구입금액 입력을 받음
- 로또 매수 계산
- Lottos와 Lotto 인스턴스 생성
- 생성된 로또 출력
- 당첨 번호 및 보너스 볼 입력
- 당첨 통계 계산
- 당첨 통계 출력