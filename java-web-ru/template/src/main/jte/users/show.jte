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
    <main class="p-4">
      <table class="table table-striped">
        <tr>
          <td>Id</td>
          <td>First name</td>
          <td>Last name</td>
          <td>Email</td>
        </tr>
        <tr>
          <td>${userPage.getUser().getId()}</td>
          <td>${userPage.getUser().getFirstName()}</td>
          <td>${userPage.getUser().getLastName()}</td>
          <td>${userPage.getUser().getEmail()}</td>
        </tr>
      </table>
    </main>
  </body>
</html>
