<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Todo-list</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
<header class="header">
    <p>Welcome, dear <span class="red-span">${sessionScope["username"]}</span></p>
    <div class="logout-button">
        <button id="logoutButton">Logout</button>
    </div>
</header>
<main class="main-wrapper">

    <h2 class="main-header">My Todo <span class="red-span">LIST</span>!</h2>

</main>
<footer>
    <p>&copy; 2025 Copyright</p>
    <p class="author">Developer by berdnikausiarhei@gmail.by</p>
</footer>

<script>
    const urlParams = new URLSearchParams(window.location.search);
    document.getElementById('logoutButton').addEventListener('click', function() {
        fetch('logout', { method: 'POST' })
            .then(response => {
                if (response.ok) {
                    window.location.href = 'login.html';
                }
            })
            .catch(error => console.error('Error:', error));
    });
</script>

</body>
</html>