@import exercise.dto.users.UserPage
@param UserPage userPage

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <title>Ha, user, ha-ha ${userPage.getUser().getId()}!</title>
    <meta  name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
  </head>
  <body>
    <main class="container">
      <div class="row">
        <p class="col-1">${userPage.getUser().getId()}</p>
        <p class="col-1">${userPage.getUser().getFirstName()}</p>
        <p class="col-1">${userPage.getUser().getLastName()}</p>
        <p class="col-1">${userPage.getUser().getEmail()}</p>
      </div>
    </main>
  </body>
</html>
