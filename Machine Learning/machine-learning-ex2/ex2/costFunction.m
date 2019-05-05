function [J, grad] = costFunction(theta, X, y)
%COSTFUNCTION Compute cost and gradient for logistic regression
%   J = COSTFUNCTION(theta, X, y) computes the cost of using theta as the
%   parameter for logistic regression and the gradient of the cost
%   w.r.t. to the parameters.

% Initialize some useful values
m = length(y); % number of training examples

% You need to return the following variables correctly 
J = 0;
grad = zeros(size(theta));
% 
% ====================== YOUR CODE HERE ======================
% Instructions: Compute the cost of a particular choice of theta.
%               You should set J to the cost.
%               Compute the partial derivatives and set grad to the partial
%               derivatives of the cost w.r.t. each parameter in theta
%
% Note: grad should have the same dimensions as theta
%
% J是输出经过costFunction后的代价函数的值%
% grad矩阵是经过costFunction后θ更新的矩阵值%
% Step1 首先要把传入的X矩阵经过sigmoid函数进行转换
A = sigmoid(X*theta);
% Step2 求J(θ)
J = sum(-y.*log(A)-(1-y).*log(1-A))/m;
grad = (X'*(A-y))/m;







% =============================================================

end
