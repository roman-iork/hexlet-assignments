@import exercise.dto.users.UsersPage
@param UsersPage users

@template.layout.page(
    content = @`
        <div>
            <form>
                <input type="search" name="term" value="${users.getTerm()}">
                <input type="submit" value="Find">
            </form>
            @if(!users.getUsers().isEmpty())
                @for(var user : users.getUsers())
                    <div>
                        <p>${user.getFirstName()} ${user.getLastName()}</p>
                    </div>
                @endfor
            @endif
        </div>

    `
)
