@import gg.jte.Content
@param Content content

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Test page.</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
</head>
<body style="background: #edd3d9">
<header class="p-2 ps-4">
    <div>
        <div class="row">
            <a href="/" class="col-auto">Main page</a>
            <a href="/users" class="col-auto">Users</a>
        </div>
    </div>
</header>
<main class="p-2 pb-0 ps-5">
    ${content}
</main>
<footer class="p-2 pt-0 ps-4" style="color: green">
    <p>This is the footer!</p>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>