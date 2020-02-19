Cypress.Commands.overwrite('visit', (orig, url, options = {}) => {
  return orig('http://localhost:3000/', options);
});