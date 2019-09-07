/**
 * Class that represents a UserList
 * 
 * @author David García Prados
 */
function UserList() {

	let _self = this;

	// Columns parameter
	let columns = [

			{
				data : "usrUsername"
			},
			{
				data : "usrActive"
			},
			{
				data : "usrRolesByComma"
			},
			{
				data : "usrId",
				render : function(id, type, row) {
					return /* Detail */'<a href="'
							+ new NavigationConstants().DETAIL_URL
							+ '?id='
							+ id
							+ '" class="btn btn-primary btn-sm fas fa-edit"></a>'
							/* Delete */
							+ ' <button data-deleteid="'
							+ id
							+ '" class="btn btn-danger btn-sm fas fa-trash-alt"></button>';
				}
			} ];

	// Datatable attribute
	_self.datatable = new CustomDatatable(columns);

	// Delete user by id function
	_self.deleteUserById = function(paramId) {

		$.ajax({
			type : 'POST',
			url : new NavigationConstants().DELETE_URL,

			data : {
				id : paramId
			},

			// Reload on success
			success : function(param) {
				_self.datatable.reload();
			},
			// Throw on error
			error : function() {
				try {
					throw ' User with id=' + paramId + ' cannot be deleted';
				} catch (ex) {
					logToServer(ex);
				}
			}
		});
	}
}

$(document).ready(function() {
	try {
		// Create user list
		let userList = new UserList();

		// Handler of delete button
		$(document).on('click', 'button[data-deleteid]', function() {
			userList.deleteUserById(this.dataset.deleteid);
		});

		// Catch exceptions and log to server
	} catch (ex) {
		logToServer(ex);
	}
});