# java-lotto

로또 미션 진행을 위한 저장소

## 요구사항

* [x] 구입금액을 입력한다.
* [x] 구입 가능한 로또 매수를 구한다.
* [ ] 수동으로 구매할 로또 수를 입력한다.
* [x] 로또를 매수만큼 생성한다.
  * [x] 번호를 입력받고 수동으로 로또를 생성한다.
  * [x] 자동으로 로또를 생성한다.
* [x] 생성된 로또들을 출력한다.
* [x] 당첨 번호를 입력 받는다.
* [x] 보너스 볼을 입력한다.
* [x] 개개별 로또 결과를 수합한다.
* [x] 당첨 통계를 계산한다.
* [x] 당첨 통계를 출력한다.

## Lotto

- 1 ~ 45 사이의 6개의 수를 가지고 있다.
- 다른 로또와 비교해서 일치하는 당첨번호의 수를 알려준다.
- 특정 수를 포함하고 있는지 알려준다.

## Lottos

- 구매한 Lotto들을 가지고 있다.
- 당첨 통계를 계산한다.

## LottoGenerator

- 1 ~ 45 사이의 6개의 랜덤 번호를 가진 로또를 생성한다.

## LottoRank

- 로또의 등수와 숫자 일치 개수, 당첨금의 정보를 가지고 있다.
- 일치 개수에 따른 등수를 알려준다.

## WinningLotto

- 당첨번호와 보너스 볼의 정보를 가지고 있다.
- 구매한 각 로또의 LottoRank를 알려준다.

## Money

- 구입금액의 정보를 가지고 있다.

## BonusBall

- 보너스 볼의 숫자에 대한 정보를 가지고 있다.

## LottoStore

- 구입금액 만큼의 로또를 살 수 있다.
- 구매한 로또의 정보를 출력한다.
- 당첨번호와 보너스 볼을 정할 수 있다.
- 수익률을 계산한다.
- 당첨 통계를 출력한다.