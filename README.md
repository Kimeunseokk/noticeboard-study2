**📌 게시판 API 문서 (Board API)
🔹 공통 정보

Base URL: http://localhost:8080

Content-Type: application/json

Response Format: JSON

인증: 없음 (비밀번호 기반 검증)

---

1️⃣ 게시글 전체 조회
📍 요청

Method: GET

URL: /api/posts

Request Body: 없음

📍 응답 (200 OK)
[
{
"id": 1,
"title": "게시글 제목",
"content": "게시글 내용",
"author": "작성자",
"createdAt": "2025-12-19T14:00:00",
"modifiedAt": "2025-12-19T14:00:00"
}
]

---

2️⃣ 게시글 단건 조회
📍 요청

Method: GET

URL: /api/posts/{id}

📍 Path Variable
이름	타입	설명
id	Long	게시글 ID
📍 응답 (200 OK)
{
"id": 1,
"title": "게시글 제목",
"content": "게시글 내용",
"author": "작성자",
"createdAt": "2025-12-19T14:00:00",
"modifiedAt": "2025-12-19T14:00:00"
}

---

3️⃣ 게시글 생성
📍 요청

Method: POST

URL: /api/posts

📍 Request Body
{
"title": "새 게시글 제목",
"content": "새 게시글 내용",
"author": "작성자",
"password": "1234"
}

📍 응답 (200 OK)
{
"id": 5,
"title": "새 게시글 제목",
"content": "새 게시글 내용",
"author": "작성자",
"createdAt": "2025-12-19T15:00:00",
"modifiedAt": "2025-12-19T15:00:00"
}

---

4️⃣ 게시글 수정
📍 요청

Method: PUT

URL: /api/posts/{id}

📍 Path Variable
이름	타입	설명
id	Long	수정할 게시글 ID
📍 Request Body
{
"title": "수정된 제목",
"content": "수정된 내용",
"password": "1234"
}

📍 응답 (200 OK)
{
"id": 1,
"title": "수정된 제목",
"content": "수정된 내용",
"author": "작성자",
"createdAt": "2025-12-19T14:00:00",
"modifiedAt": "2025-12-19T16:00:00"
}

---

5️⃣ 게시글 삭제
📍 요청

Method: DELETE

URL: /api/posts/{id}

📍 Path Variable
이름	타입	설명
id	Long	삭제할 게시글 ID
📍 Request Body
{
"password": "1234"
}

📍 응답

Status: 204 No Content

Response Body: 없음

⚠️ 에러 응답 공통
❌ 잘못된 요청 (400)
{
"message": "잘못된 요청입니다."
}

❌ 게시글 없음 (404)
{
"message": "아이디가 존재하지 않습니다."
}

❌ 비밀번호 불일치 (400)
{
"message": "비밀번호가 일치하지 않습니다."
}
**