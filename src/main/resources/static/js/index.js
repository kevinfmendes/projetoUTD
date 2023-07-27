function confirmDelete(event) {
  // Impedir o comportamento padrão
  event.preventDefault();
  const url = event.target.attributes[0].value;
  // Exibir uma mensagem de confirmação 
  Swal.fire({
    title: 'Tem certeza que deseja excluir este livro?',
    text: "Esta ação não pode ser desfeita!",
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Sim, excluir!',
    cancelButtonText: 'Cancelar'
  }).then((result) => {
    if (result.isConfirmed) {
      // Se confirmar, continua e exclui no controller
      window.location.href = url;
    }
  })
}



