const conf = Cypress.config();

const deleteAllFizzBuzzItems = () => {
  try {
    cy.log('Delete all secuForms (via API)');
    cy.request({
      method: 'DELETE',
      url: `${conf.baseUrl}api/fizzbuzz/all`,
    });
  } catch(e) {
    cy.log('Error deleting fizzbuzz items ', e);
  }
};

export {
  deleteAllFizzBuzzItems,
};
