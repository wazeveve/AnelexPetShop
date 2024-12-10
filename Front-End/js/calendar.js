document.addEventListener('DOMContentLoaded', function() {
  var calendarEl = document.getElementById('calendar');

  var calendar = new FullCalendar.Calendar(calendarEl, {
    plugins: [ 'interaction', 'dayGrid' ],
    defaultDate: '2024-09-12',
    editable: true,
    eventLimit: true,
    events: [
      {
        title: 'Consulta Marcia Ferreira',
        start: '2024-09-02'
      },
      {
        title: 'Cirurgia Pedro Henrique',
        start: '2024-09-05',
        end: '2024-09-07'
      },
      {
        groupId: 999,
        title: 'Vacinas Karla Freitas',
        start: '2024-09-09'
      },
      {
        groupId: 999,
        title: 'Visita Jorlan Silva',
        start: '2024-09-09'
      },
      {
        title: 'Conferência ExpoVet',
        start: '2024-09-11',
        end: '2024-09-13'
      },
      {
        title: 'Consulta Lucas Souza',
        start: '2024-09-10'
      },
      {
        title: 'Consulta Joaquim Pereira',
        start: '2024-09-17'
      },
      {
        title: 'Consulta Lucas Silva',
        start: '2024-09-17'
      },
      {
        title: 'Consulta Pedro Ferreira',
        start: '2024-09-17'
      },
      {
        title: 'Vacinação Otavio Mattar',
        start: '2024-09-20'
      },
      {
        title: 'Visita Hugo Peraldo',
        start: '2024-09-23'
      },
      {
        title: 'Consulta Daniel Souza',
        start: '2024-09-24'
      },
      {
        title: 'Consulta Fellipe Marciano',
        start: '2024-09-27'
      }
    ]
  });

  calendar.render();
});
