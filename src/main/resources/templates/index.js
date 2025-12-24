const API_URL = "http://localhost:8080/api/posts";

// 페이지 로드 시 전체 조회
window.onload = () => {
    loadPosts();
};

// 전체 게시글 조회
function loadPosts() {
    fetch(API_URL)
        .then(res => res.json())
        .then(data => {
            const list = document.getElementById("postList");
            list.innerHTML = "";

            data.forEach(post => {
                const li = document.createElement("li");
                li.innerHTML = `
                    <strong>${post.title}</strong><br>
                    ${post.content}
                    <button onclick="deletePost(${post.id})">삭제</button>
                `;
                list.appendChild(li);
            });
        });
}

// 게시글 생성
function createPost() {
    const title = document.getElementById("title").value;
    const content = document.getElementById("content").value;

    fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            title: title,
            content: content
        })
    })
    .then(res => res.json())
    .then(() => {
        document.getElementById("title").value = "";
        document.getElementById("content").value = "";
        loadPosts();
    });
}

// 게시글 삭제
function deletePost(id) {
    fetch(`${API_URL}/${id}`, {
        method: "DELETE"
    })
    .then(() => loadPosts());
}
