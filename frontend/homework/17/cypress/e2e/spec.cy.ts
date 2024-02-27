describe("template spec", () => {
  it("passes", () => {
    cy.visit("http://localhost:5173");
    cy.get("#sub-heading").should("exist");
    const SAMPLE_CONTENT_ONE = "Sanskar is typing ONE";
    cy.get("#input-field").focus().clear().type(SAMPLE_CONTENT_ONE).blur();

    cy.get("#submit-btn").click();
    cy.get("#search-bar").type("San");

    cy.get("#list-container").contains(SAMPLE_CONTENT_ONE);

    cy.get("#checkbox-input").click();

    cy.get("#delete-btn").click();
  });
});
