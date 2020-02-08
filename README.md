- http://ec2-13-124-233-59.ap-northeast-2.compute.amazonaws.com:8080/

#### Practice 
- Spring boot + JPA + OAuth2 (Spring security)-google, naver
- AWS (EC2, RDS)
- CI (Travis CI)
- CD (AWS S3, CodeDeploy)
- 무중단 배포 (Nginx)



-----
## 메모

- 관리 용이성으로 .ssh / config 만들어서 활용.

### 아마존 리눅스 1 서버 생성시 꼭 해야 할 설정

#### 1. Java 8 설치 (기본 7로 설치되어 있음)
- sudo yum install -y java-1.8.0-openjdk-devel.x86_64
- sudo /usr/sbin/alternatives —config java
  - 선택하여 1.8로 변경
- sudo yum remove java-1.7.0-openjdk
- java -version


#### 2. 타임존 변경 (기본 세계 표준시간 UTC, 한국이랑 9시간 차이)
- sudo rm /etc/localtime
- sudo ln -s /usrshare/zoneinfo/Asia/Seoul /etc/localtime
- date 명령어로 확인
    
    
#### 3. 호스트네임 변경 
- ip만으로 어느 서비스인지 구분 어려움.
- sudo vim /etc/sysconfig/network
  - 편집 파일 열어서 변경 (HOSTNAME)
  - 재부팅 sudo reboot
- 호스트 주소를 찾을때 가장 먼저 검색해보는 /etc/hosts에 변경한 내역 등록
- sudo vim /etc/hosts
  