@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        @if(!page.getUsers().isEmpty())
            @for(var user : page.getUsers())
                <table class="table table-striped table-bordered">
                    <tr>
                        <td style="width: 50px">${user.getId()}</td>
                        <td>
                            <a href="/users/${user.getId()}">
                                ${user.getFirstName()} ${user.getLastName()}
                            </a>
                        </td>
                    </tr>
                </table>
            @endfor
        @endif
    `
)
