const form = document.querySelector('form');
const tituloInput = document.getElementById('titulo');
const autorInput = document.getElementById('autor');
const quantidadeInput = document.getElementById('quantidade');
const precoInput = document.getElementById('preco');

form.addEventListener('submit', validaInfos);

function validaInfos(event) {
  event.preventDefault();

  const inputs = [
    { input: tituloInput, label: 'Título' },
    { input: autorInput, label: 'Autor' },
    { input: quantidadeInput, label: 'Quantidade' },
    { input: precoInput, label: 'Preço' },
  ];

  let isFormValid = true;

  for (const { input, label } of inputs) {
    const value = input.value.trim();

    if (value === '') {
      Swal.fire({
        icon: 'error',
        title: 'Você precisa preencher todos os campos!',
        text: `O campo ${label.toLowerCase()} está vazio, por favor preencha.`,
      });
      input.focus();
      isFormValid = false;
      break;
    }
  }

  if (isFormValid) {
    form.submit();
  }
}
