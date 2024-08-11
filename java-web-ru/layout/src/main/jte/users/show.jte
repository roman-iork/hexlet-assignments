@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
    content = @`
        <table class="table table-striped table-bordered">
            <tr>
                <td>Id</td>
                <td>First name</td>
                <td>Last name</td>
                <td>Email</td>
            </tr>
            <tr>
                <td>
                    ${page.getUser().getId()}
                </td>
                <td>
                    ${page.getUser().getFirstName()}
                </td>
                <td>
                    ${page.getUser().getLastName()}
                </td>
                <td>
                    ${page.getUser().getEmail()}
                </td>
            </tr>
        </table>
    `
)
