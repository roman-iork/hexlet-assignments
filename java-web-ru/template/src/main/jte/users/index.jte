@import exercise.dto.users.UsersPage
@param UsersPage usersPage

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <title>Yo fellows, my page!</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
  </head>
  <body>
    <div class="p-4">
      <h2>Users</h2>
      <main>
        @if(!usersPage.getUsers().isEmpty())
          @for(var user : usersPage.getUsers())
            <div class="row">
              <p class="col-auto">${user.getId()}</p>
              <a href="/users/${user.getId()}" class="col-2">${user.getFirstName() + " " + user.getLastName()}</a>
            </div>
          @endfor
        @endif
      </main>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  </body>
</html>
