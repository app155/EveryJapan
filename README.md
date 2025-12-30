# Globalin - 일본 대학 유학생 커뮤니티

일본 대학에 재학 중인 한국 유학생들을 위한 커뮤니티 플랫폼입니다.

## 📋 목차

- [프로젝트 개요](#프로젝트-개요)
- [기술 스택](#기술-스택)
- [프로젝트 구조](#프로젝트-구조)
- [파일별 기능 담당](#파일별-기능-담당)
- [시작하기](#시작하기)
- [API 문서](#api-문서)
- [배포](#배포)

---

## 🎯 프로젝트 개요

### 주요 기능

- 👤 사용자 프로필 관리
- 📝 게시판 시스템 (인문학, 자유게시판 등)
- 🔥 HOT 게시글 추천
- ⭐ BEST 게시판 추천
- 🔍 실시간 검색

### 디자인 컨셉

**브랜드 색상:**
- 🌿 **민트 그린** (#C6E5D1) - 헤더 배경
- 💜 **보라색** (#937EBF, #433461) - 주요 텍스트 및 강조
- 🧡 **오렌지** (#FE9F1A) - 액센트 및 호버 효과

---

## 🛠 기술 스택

### 백엔드
```
언어:        Java 8 (OpenJDK 1.8.0)
프레임워크:   Spring Framework 5.3.31
빌드 도구:    Maven 3.9.11
ORM:         MyBatis 3.5.13
웹 서버:      Apache Tomcat 7.0.47
데이터베이스: MariaDB 10.x
JDBC Driver: mariadb-java-client 2.7.9
```

### 프론트엔드
```
언어:        TypeScript 4.9
프레임워크:   React 18.3.1
스타일링:     SCSS
빌드 도구:    React Scripts 5.0.1
HTTP 클라이언트: Fetch API
```

### 인프라 & 배포
```
컨테이너:     Docker & Docker Compose
웹 서버:      Nginx (프로덕션)
프록시:       Nginx Reverse Proxy
로깅:        Logback 1.2.11
```

---

## 📁 프로젝트 구조

```
Globalin/
├── 📦 backend/                          # 백엔드 Spring 애플리케이션
│   ├── src/main/
│   │   ├── java/com/example/Globalin/
│   │   │   ├── 🎮 controller/          # REST API 컨트롤러
│   │   │   │   ├── HealthCheckController.java      # 헬스 체크 API
│   │   │   │   └── MainPageController.java         # 메인 페이지 통합 API
│   │   │   │
│   │   │   ├── 💼 service/             # 비즈니스 로직
│   │   │   │   ├── BoardService.java               # 게시판/게시글 서비스
│   │   │   │   └── UserService.java                # 사용자 서비스
│   │   │   │
│   │   │   ├── 📊 model/               # 도메인 모델 (Entity)
│   │   │   │   ├── Board.java                      # 게시판 엔티티
│   │   │   │   ├── Post.java                       # 게시글 엔티티
│   │   │   │   ├── HotPost.java                    # HOT 게시글 엔티티
│   │   │   │   └── UserProfile.java                # 사용자 프로필 엔티티
│   │   │   │
│   │   │   └── 📦 dto/                 # 데이터 전송 객체
│   │   │       └── MainPageDTO.java                # 메인 페이지 통합 DTO
│   │   │
│   │   ├── resources/
│   │   │   ├── ⚙️  spring/             # Spring 설정
│   │   │   │   ├── applicationContext.xml          # 루트 컨텍스트 (Bean, DB)
│   │   │   │   └── dispatcher-servlet.xml          # MVC 설정 (Controller, CORS)
│   │   │   │
│   │   │   ├── 🗄️  mybatis/            # MyBatis 설정
│   │   │   │   ├── mybatis-config.xml              # MyBatis 전역 설정
│   │   │   │   └── mappers/                        # SQL Mapper XML
│   │   │   │
│   │   │   └── 🔧 config/              # 애플리케이션 설정
│   │   │       └── database.properties             # MariaDB 연결 설정
│   │   │
│   │   └── webapp/WEB-INF/
│   │       └── web.xml                             # 웹 애플리케이션 설정
│   │
│   ├── 🐳 Dockerfile                    # 백엔드 Docker 이미지
│   ├── .dockerignore
│   └── 📦 pom.xml                       # Maven 의존성 관리
│
├── 🌐 frontend/                         # 프론트엔드 React 애플리케이션
│   ├── public/
│   │   ├── index.html
│   │   ├── favicon.ico
│   │   └── manifest.json
│   │
│   ├── src/
│   │   ├── 🧩 components/
│   │   │   ├── common/                             # 공통 컴포넌트
│   │   │   │   ├── Header.tsx                      # 사이트 헤더
│   │   │   │   └── Header.scss                     # 헤더 스타일
│   │   │   │
│   │   │   └── pages/                              # 페이지 컴포넌트
│   │   │       ├── MainPage.tsx                    # 메인 페이지 컨테이너
│   │   │       ├── MainPage.scss
│   │   │       └── components/                     # 메인 페이지 하위 컴포넌트
│   │   │           ├── LeftSidebar.tsx             # 사용자 프로필 영역
│   │   │           ├── LeftSidebar.scss
│   │   │           ├── MainContent.tsx             # 게시글 목록 영역
│   │   │           ├── MainContent.scss
│   │   │           ├── RightSidebar.tsx            # HOT/BEST 영역
│   │   │           └── RightSidebar.scss
│   │   │
│   │   ├── 📝 types/                               # TypeScript 타입 정의
│   │   │   └── index.ts
│   │   │
│   │   ├── App.tsx                                 # 루트 컴포넌트
│   │   ├── App.css
│   │   ├── index.tsx                               # 진입점
│   │   └── index.css
│   │
│   ├── 🌍 .env.development              # 개발 환경 변수
│   ├── 🌍 .env.production               # 프로덕션 환경 변수
│   ├── 🐳 Dockerfile                    # 프론트엔드 Docker 이미지
│   ├── 🔧 nginx.conf                    # Nginx 설정
│   ├── .dockerignore
│   ├── 📦 package.json                  # npm 의존성
│   └── tsconfig.json                    # TypeScript 설정
│
├── 🐳 docker-compose.yml                # Docker Compose 오케스트레이션
├── 🚀 deploy.sh                         # 자동 배포 스크립트
├── .gitignore
├── 📖 README.md                         # 이 파일
└── 📖 README-DOCKER.md                  # Docker 배포 가이드
```

---

## 🎯 파일별 기능 담당

### 백엔드 컴포넌트

#### 🎮 Controllers (컨트롤러)
| 파일 | 엔드포인트 | 기능 |
|------|------|------|
| `HealthCheckController.java` | `GET /api/health` | 서버 상태 체크 (헬스 체크) |
| `MainPageController.java` | `GET /api/main/dashboard` | 메인 페이지 전체 데이터 통합 제공 |

#### 💼 Services (서비스 - 비즈니스 로직)
| 파일 | 담당 기능 |
|------|------|
| `BoardService.java` | • 게시판 관리<br>• 최신 게시글 조회<br>• HOT 게시글 선정<br>• BEST 게시판 선정 |
| `UserService.java` | • 사용자 프로필 조회<br>• 사용자 통계 (게시글/댓글 수) |

#### 📊 Models (도메인 모델)
| 파일 | 담당 데이터 |
|------|------|
| `Board.java` | 게시판 정보 (ID, 이름, 설명, 카테고리, 아이콘) |
| `Post.java` | 게시글 정보 (제목, 내용, 작성자, 조회수, 좋아요, 댓글수) |
| `HotPost.java` | HOT 게시글 (인기 게시글 요약 정보) |
| `UserProfile.java` | 사용자 프로필 (닉네임, 이메일, 통계, 가입일) |

#### 📦 DTOs (데이터 전송 객체)
| 파일 | 담당 데이터 |
|------|------|
| `MainPageDTO.java` | 메인 페이지 전체 데이터 통합<br>(사용자 프로필 + 게시글 + HOT + BEST) |

#### ⚙️ 설정 파일
| 파일 | 역할 |
|------|------|
| `web.xml` | • DispatcherServlet 매핑 (`/*`)<br>• 인코딩 필터 (UTF-8)<br>• 세션 타임아웃 |
| `applicationContext.xml` | • Bean 스캔 설정<br>• DataSource (MariaDB 연결)<br>• MyBatis 연동<br>• 트랜잭션 관리 |
| `dispatcher-servlet.xml` | • Controller 스캔<br>• MVC 설정<br>• JSON 변환 (Jackson)<br>• CORS 설정 (localhost:3000) |
| `mybatis-config.xml` | • TypeAlias 설정<br>• Mapper 위치 지정 |
| `database.properties` | • MariaDB 연결 정보<br>• Connection Pool 설정 |
| `pom.xml` | • Maven 의존성 관리<br>• 빌드 플러그인 설정 |

---

### 프론트엔드 컴포넌트

#### 🧩 공통 컴포넌트
| 파일 | 역할 |
|------|------|
| `Header.tsx` | • 사이트 로고 표시<br>• 사이트 제목 (Globalin)<br>• 검색바<br>• 상단 고정 (sticky) |
| `Header.scss` | • 민트 그린 그라디언트 배경<br>• 보라색 텍스트 스타일<br>• 반응형 레이아웃 |

#### 📄 페이지 컴포넌트
| 파일 | 역할 |
|------|------|
| `MainPage.tsx` | • 메인 페이지 컨테이너<br>• API 호출 (`/api/main/dashboard`)<br>• 로딩/에러 상태 관리<br>• 하위 컴포넌트 조합 |
| `MainPage.scss` | • 3단 레이아웃 스타일<br>• 로딩/에러 메시지 스타일<br>• 반응형 미디어 쿼리 |

#### 🧩 메인 페이지 하위 컴포넌트
| 파일 | 담당 영역 |
|------|------|
| `LeftSidebar.tsx` | • 사용자 프로필 카드<br>• 아바타 이미지<br>• 게시글/댓글 통계<br>• 가입일 표시 |
| `LeftSidebar.scss` | • 보라색 그라디언트 아바타<br>• 민트 그린 테두리<br>• 보라색 통계 숫자 |
| `MainContent.tsx` | • 인문학 게시판 최신글<br>• 자유게시판 최신글<br>• 게시글 카드 표시 |
| `MainContent.scss` | • 보라색 섹션 테두리<br>• 오렌지 호버 효과<br>• 카드 레이아웃 스타일 |
| `RightSidebar.tsx` | • HOT 게시글 목록<br>• BEST 게시판 목록<br>• 게시판 아이콘 표시 |
| `RightSidebar.scss` | • 오렌지 호버 효과 (HOT)<br>• 민트 그린 호버 (BEST)<br>• 오렌지 통계 텍스트 |

#### 📝 타입 정의
| 파일 | 정의 타입 |
|------|------|
| `types/index.ts` | • UserProfile<br>• Post<br>• HotPost<br>• Board |

#### 🔧 설정 파일
| 파일 | 역할 |
|------|------|
| `package.json` | • npm 의존성 목록<br>• 빌드/실행 스크립트 |
| `tsconfig.json` | • TypeScript 컴파일 옵션<br>• 경로 alias 설정 |
| `.env.development` | • 개발 환경 API URL<br>  (http://localhost:8080) |
| `.env.production` | • 프로덕션 환경 API URL<br>  (nginx 프록시 사용) |
| `nginx.conf` | • 정적 파일 서빙<br>• API 프록시 (/api/* → backend:8080)<br>• Gzip 압축<br>• 보안 헤더 |

---

### 🐳 배포 관련 파일
| 파일 | 역할 |
|------|------|
| `docker-compose.yml` | • 백엔드/프론트엔드 컨테이너 정의<br>• 네트워크 설정<br>• 헬스 체크 설정<br>• 환경 변수 관리 |
| `backend/Dockerfile` | • 멀티 스테이지 빌드<br>  (Maven 빌드 → Tomcat 런타임)<br>• WAR 파일 배포 |
| `frontend/Dockerfile` | • 멀티 스테이지 빌드<br>  (Node 빌드 → Nginx 런타임)<br>• 정적 파일 최적화 |
| `deploy.sh` | • 환경 체크<br>• 포트 충돌 확인<br>• Docker 빌드/실행<br>• 헬스 체크 |

---

## 🚀 시작하기

### 사전 요구사항

#### 로컬 개발
- **Java**: OpenJDK 8 이상
- **Maven**: 3.9 이상
- **Node.js**: 18 이상
- **npm**: 8 이상
- **MariaDB**: 10.x 이상

#### Docker 배포
- **Docker**: 20.10 이상
- **Docker Compose**: 2.0 이상

---

### 로컬 개발 환경 설정

#### 1️⃣ MariaDB 설정

```bash
# MariaDB 설치 (macOS)
brew install mariadb

# MariaDB 시작
brew services start mariadb

# 데이터베이스 생성
mysql -u root -p
CREATE DATABASE globalin CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
EXIT;
```

#### 2️⃣ 백엔드 실행

```bash
cd backend

# 데이터베이스 설정 확인
cat src/main/resources/config/database.properties

# Maven 의존성 설치 및 서버 실행
./mvnw tomcat7:run

# 서버 실행 확인 (다른 터미널에서)
curl http://localhost:8080/api/health
```

#### 3️⃣ 프론트엔드 실행

```bash
cd frontend

# npm 의존성 설치
npm install

# 개발 서버 실행
npm start
```

#### 4️⃣ 브라우저 접속

- **프론트엔드**: http://localhost:3000
- **백엔드 API**: http://localhost:8080/api/health

---

## 📡 API 문서

### 엔드포인트 목록

#### 1. 헬스 체크
```http
GET /api/health
```

**설명**: 백엔드 서버 상태 확인

**응답**:
```json
{
  "status": "OK",
  "message": "Globalin API is running",
  "timestamp": 1704067200000
}
```

---

#### 2. 메인 페이지 데이터
```http
GET /api/main/dashboard
```

**설명**: 메인 페이지에 필요한 모든 데이터를 한 번에 제공

**응답**:
```json
{
  "userProfile": {
    "id": 1,
    "username": "student123",
    "email": "student@example.com",
    "nickname": "유학생",
    "avatar": null,
    "postCount": 15,
    "commentCount": 42,
    "joinDate": 1704067200000
  },
  "humanitiesPosts": [
    {
      "id": 1,
      "title": "일본 대학 생활 적응 팁 공유합니다",
      "content": "안녕하세요! 일본 대학에 온 지 1년이 되어서...",
      "author": "김유학",
      "authorId": 2,
      "createdAt": 1704067200000,
      "viewCount": 156,
      "commentCount": 23,
      "likeCount": 45,
      "boardId": 1,
      "boardName": "인문학"
    }
  ],
  "freePosts": [ /* ... */ ],
  "hotPosts": [
    {
      "id": 5,
      "title": "일본 대학 장학금 정보 총정리",
      "author": "정보왕",
      "viewCount": 892,
      "commentCount": 67,
      "likeCount": 134,
      "createdAt": 1704067200000,
      "isHot": true
    }
  ],
  "bestBoards": [
    {
      "id": 1,
      "name": "인문학",
      "description": "문학, 철학, 역사 등",
      "postCount": 234,
      "category": "학술",
      "icon": "📚"
    }
  ]
}
```

---

## 🐳 배포

### Docker를 사용한 배포

#### 빠른 배포 (추천)
```bash
cd /Users/yunsu-in/Downloads/Globalin

# 자동 배포 스크립트 실행
./deploy.sh
```

#### 수동 배포
```bash
# Docker Compose로 빌드 및 실행
docker-compose up -d

# 로그 확인
docker-compose logs -f

# 특정 서비스 로그만 확인
docker-compose logs -f backend
docker-compose logs -f frontend

# 중지
docker-compose stop

# 완전 제거
docker-compose down
```

#### 배포 후 접속
- **프론트엔드**: http://localhost
- **백엔드 API**: http://localhost:8080/api/health

자세한 배포 가이드는 **[README-DOCKER.md](./README-DOCKER.md)** 참조

---

## 🎨 개발 가이드

### 색상 시스템

프로젝트 전체에서 일관된 브랜드 색상을 사용하세요:

```scss
// 📁 _colors.scss (권장 변수)

// Primary Colors
$mint-green: #C6E5D1;          // 민트 그린 (헤더 배경)
$mint-green-dark: #a8d5ba;     // 민트 그린 (진한 톤)

$purple-light: #937EBF;         // 보라색 (강조, 테두리)
$purple-dark: #433461;          // 보라색 (텍스트, 타이틀)

$orange: #FE9F1A;               // 오렌지 (액센트, 호버)

// Usage Examples
.header {
  background: linear-gradient(135deg, $mint-green 0%, $mint-green-dark 100%);
}

.title {
  color: $purple-dark;
}

.button:hover {
  border-color: $orange;
}

.stat-value {
  color: $purple-light;
}
```

---

### 새로운 기능 추가하기

#### 백엔드 API 추가
1. **Controller 생성**
   ```java
   // src/main/java/com/example/Globalin/controller/
   @RestController
   @RequestMapping("/api/boards")
   public class BoardController {
       @GetMapping("/{id}")
       public ResponseEntity<Board> getBoard(@PathVariable Long id) {
           // ...
       }
   }
   ```

2. **Service 로직 구현**
   ```java
   // src/main/java/com/example/Globalin/service/
   @Service
   public class BoardDetailService {
       public Board getBoardById(Long id) {
           // ...
       }
   }
   ```

#### 프론트엔드 페이지 추가
1. **컴포넌트 생성**
   ```typescript
   // src/components/pages/BoardDetail/BoardDetail.tsx
   import React from 'react';
   import './BoardDetail.scss';

   const BoardDetail: React.FC = () => {
       return <div className="board-detail">...</div>;
   };
   ```

2. **스타일 추가**
   ```scss
   // src/components/pages/BoardDetail/BoardDetail.scss
   .board-detail {
       max-width: 1200px;
       margin: 0 auto;

       .title {
           color: $purple-dark;
       }
   }
   ```

---

## 🔧 트러블슈팅

### 백엔드

#### 포트 8080 충돌
```bash
# 포트 사용 중인 프로세스 확인
lsof -i:8080

# 프로세스 종료
lsof -ti:8080 | xargs kill -9
```

#### MariaDB 연결 실패
```bash
# MariaDB 상태 확인
brew services list | grep mariadb

# MariaDB 재시작
brew services restart mariadb

# 연결 테스트
mysql -u root -p -e "SHOW DATABASES;"
```

---

### 프론트엔드

#### npm 빌드 실패
```bash
# node_modules 재설치
rm -rf node_modules package-lock.json
npm install
```

#### API 연결 실패
```bash
# .env.development 확인
cat frontend/.env.development
# REACT_APP_API_URL=http://localhost:8080

# 백엔드 서버 실행 확인
curl http://localhost:8080/api/health
```

---

### Docker

#### 컨테이너 빌드 실패
```bash
# 캐시 없이 재빌드
docker-compose build --no-cache

# 모든 컨테이너 및 이미지 제거 후 재시작
docker-compose down -v --rmi all
docker-compose up -d
```

#### 헬스 체크 실패
```bash
# 컨테이너 로그 확인
docker-compose logs backend
docker-compose logs frontend

# 컨테이너 내부 접속
docker exec -it globalin-backend /bin/bash
docker exec -it globalin-frontend /bin/sh
```

---

## 📝 라이센스

이 프로젝트는 교육 목적으로 만들어졌습니다.

---

## 👥 기여

버그 리포트나 기능 제안은 이슈로 등록해주세요.

---

## 📧 연락처

프로젝트 관련 문의: yunsu-in@example.com
