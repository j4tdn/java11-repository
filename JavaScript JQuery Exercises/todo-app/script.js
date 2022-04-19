$(document).ready(function() {

	$('.task-cbx input').prop('checked', false);

	let btnAdd = $('.add-button');
	let tasks = $('.tasks');
	let input = $('.add-text');
	let message = $('.message');

	btnAdd.on('click', function() {
		if (input.val()) {
			let task = `<li class="task">
							<div class="task-cbx">
								<input type="checkbox" unchecked>
							</div>
							<div class="task-text">${input.val()}</div>
							<div class="task-remove"></div>
						</li>`;	

			tasks.append(task);
			input.val('');
			message.css('visibility', 'hidden');
		} else {
		    message.css('visibility', 'visible');
		}
	})

	input.keyup(function() {
		message.css('visibility', input.val() ? 'hidden' : 'visible');
	})

	tasks.on('click', '.task-remove', function() {
		let isConfirmed = confirm('Click OK to remove this task !');
		if (isConfirmed) {
			$(this).parent().remove();	
		}
	})

	tasks.on('click', '.task-cbx input', function() {
		$(this).parent().next().toggleClass('checked');
	})

	$('#sortable-list').sortable();
})