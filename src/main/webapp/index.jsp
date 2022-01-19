<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>index</title>
</head>
<body>
<div class="container">
    <div class="d-grid gap-2 col-6 mx-auto">
        <form action="/customerLogin">
            <button class="btn btn-success" type=submit>Login as a customer</button>
        </form>
        <form action=/expertLogin>
            <button class="btn btn-danger" type=submit>Login as a Expert</button>
        </form>
        <form action="/managerLogin">
            <button class="btn btn-warning" type=submit>Login as a manager</button>
        </form>
    </div>
</div>
</body>
</html>