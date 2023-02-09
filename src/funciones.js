import Swal from 'sweetalert2';
import withReactContent from 'sweetalert2-react-content';

export function mostrar_alerta(mensaje, icono, foco=''){
    onfocus(foco);
    const mySwal = withReactContent(Swal);
    mySwal.fire({
        title: mensaje,
        icon: icono
    });
}

function onfocus(foco){
    if(foco !== ''){
        document.getElementById(foco).focus();
    }
}